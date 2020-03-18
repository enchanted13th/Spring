package springbook.user.service;

import springbook.user.domain.User;

public interface UserLevelUpgradePolicy {
    int MIN_LOGCOUNT_FOR_SILVER = 50;
    int MIN_RECCOMEND_FOR_GOLD = 30;

    boolean canUpgradeLevel(User user);
    void upgradeLevel(User user);
}
