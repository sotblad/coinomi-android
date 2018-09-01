package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class MonetaryUnitMain extends PeerFamily {
    private MonetaryUnitMain() {
        id = "monetaryunit.main";

        addressHeader = 16;
        p2shHeader = 76;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 126;

        name = "MonetaryUnit";
        symbol = "MUE";
        uriScheme = "monetaryunit";
        bip44Index = 31;
        unitExponent = 8;
        feeValue = value(1000); // 0.00001 MUE
        minNonDust = value(1);
        softDustLimit = value(100000); // 0.001 MUE
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("MonetaryUnit Signed Message:\n");
    }

    private static MonetaryUnitMain instance = new MonetaryUnitMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
