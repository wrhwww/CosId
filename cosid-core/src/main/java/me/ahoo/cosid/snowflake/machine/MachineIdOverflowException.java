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

package me.ahoo.cosid.snowflake.machine;

import me.ahoo.cosid.CosIdException;

import com.google.common.base.Strings;

/**
 * MachineId Overflow Exception.
 *
 * @author ahoo wang
 */
public class MachineIdOverflowException extends CosIdException {
    private final int totalMachineIds;
    private final InstanceId instanceId;

    public MachineIdOverflowException(int totalMachineIds, InstanceId instanceId) {
        super(Strings.lenientFormat("InstanceId:[%s] - distribution failed - totalMachineIds:[%s]", instanceId, totalMachineIds));
        this.totalMachineIds = totalMachineIds;
        this.instanceId = instanceId;
    }

    public int getTotalMachineIds() {
        return totalMachineIds;
    }

    public InstanceId getInstanceId() {
        return instanceId;
    }
}
