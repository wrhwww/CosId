package me.ahoo.cosid.spring.boot.starter.redis;

import me.ahoo.cosid.IdGenerator;
import me.ahoo.cosid.provider.IdGeneratorProvider;
import me.ahoo.cosid.redis.RedisIdGenerator;
import me.ahoo.cosid.spring.boot.starter.ConditionalOnCosIdEnabled;
import me.ahoo.cosid.spring.boot.starter.CosIdProperties;
import me.ahoo.cosky.core.redis.RedisConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @author ahoo wang
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnCosIdEnabled
@ConditionalOnCosIdRedisEnabled
@EnableConfigurationProperties(RedisIdProperties.class)
public class CosIdRedisAutoConfiguration {

    private final CosIdProperties cosIdProperties;
    private final RedisIdProperties redisIdProperties;

    public CosIdRedisAutoConfiguration(CosIdProperties cosIdProperties, RedisIdProperties redisIdProperties) {
        this.cosIdProperties = cosIdProperties;
        this.redisIdProperties = redisIdProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(RedisConnectionFactory.class)
    public RedisIdGenerator shareIdGenerator(RedisConnectionFactory redisConnectionFactory, IdGeneratorProvider idGeneratorProvider) {
        RedisIdProperties.Provider redisIdPropertiesShare = redisIdProperties.getShare();
        RedisIdGenerator shareIdGen = new RedisIdGenerator(cosIdProperties.getNamespace(), "share", redisIdPropertiesShare.getStep(), redisConnectionFactory.getShareAsyncCommands());
        idGeneratorProvider.setShare(shareIdGen);
        if (Objects.isNull(redisIdProperties.getProviders())) {
            return shareIdGen;
        }
        redisIdProperties.getProviders().forEach((name, provider) -> {
            IdGenerator idGenerator = new RedisIdGenerator(cosIdProperties.getNamespace(), name, redisIdPropertiesShare.getStep(), redisConnectionFactory.getShareAsyncCommands());
            idGeneratorProvider.set(name, idGenerator);
        });

        return shareIdGen;
    }

}
