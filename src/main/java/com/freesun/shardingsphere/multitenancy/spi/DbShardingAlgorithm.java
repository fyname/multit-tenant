package com.freesun.shardingsphere.multitenancy.spi;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Collections;

/**
 * * @author fyname
 * * @date 2021-11-20
 */
public class DbShardingAlgorithm implements StandardShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        String targetTable = shardingValue.getValue();
        if (availableTargetNames.contains(targetTable)) {
            return targetTable;
        }

        throw new UnsupportedOperationException("无法判定的值: " + shardingValue.getValue());
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        return Collections.emptyList();
    }

    @Override
    public String getType() {
        return "CLASS_BASED";
    }

    @Override
    public void init() {

    }
}
