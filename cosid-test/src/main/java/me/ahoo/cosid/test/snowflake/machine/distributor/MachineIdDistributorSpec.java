/*
 * Copyright [2021-present] [ahoo wang <ahoowang@qq.com> (https://github.com/Ahoo-Wang)].
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.ahoo.cosid.test.snowflake.machine.distributor;

import me.ahoo.cosid.snowflake.machine.InstanceId;
import me.ahoo.cosid.snowflake.machine.MachineIdDistributor;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

/**
 * DistributorSpec .
 *
 * @author ahoo wang
 */
public abstract class MachineIdDistributorSpec {
    public static final String TEST_HOST = "127.0.0.1";
    public static final int TEST_MACHINE_BIT = 5;
    
    static InstanceId mockInstance(int port, boolean stable) {
        return InstanceId.of(TEST_HOST, port, stable);
    }
    
    static List<InstanceId> mockInstances(int totalMachineIds, boolean stable) {
        List<InstanceId> instanceIds = Lists.newArrayListWithCapacity(totalMachineIds);
        for (int i = 0; i < totalMachineIds; i++) {
            InstanceId instanceId = mockInstance(i, stable);
            instanceIds.add(instanceId);
        }
        return instanceIds;
    }
    
    static List<InstanceId> allInstances(int machineBit, boolean stable) {
        int totalMachineIds = MachineIdDistributor.totalMachineIds(machineBit);
        return mockInstances(totalMachineIds, stable);
    }
    
    static List<InstanceId> allInstancesMoreOne(int machineBit, boolean stable) {
        int totalMachineIds = MachineIdDistributor.totalMachineIds(machineBit);
        return mockInstances(totalMachineIds + 1, stable);
    }
    
    protected abstract MachineIdDistributor getDistributor();
    
    @Test
    public void distribute() {
        new Distribute(this::getDistributor).verify();
    }
    
    @Test
    public void distributeOverflow() {
        new DistributeOverflow(this::getDistributor).verify();
    }
    
    @Test
    public void distributeRevert() {
        new DistributeRevert(this::getDistributor).verify();
    }
    
    @Test
    public void distributeSafeGuard() {
        new DistributeSafeGuard(this::getDistributor).verify();
    }
    
    @Test
    public void guard() {
        new Guard(this::getDistributor).verify();
    }
    
    @Test
    public void guardLost() {
        new GuardLost(this::getDistributor).verify();
    }
    
    @Test
    public void distributeStable() {
        new DistributeStable(this::getDistributor).verify();
    }
    
    @Test
    public void revert() {
        new Revert(this::getDistributor).verify();
    }
    
    @Test
    public void distributeConcurrent() {
        new DistributeConcurrent(this::getDistributor).verify();
    }
    
    @Test
    public void distributeIdempotent() {
        new DistributeIdempotent(this::getDistributor).verify();
    }
    
}
