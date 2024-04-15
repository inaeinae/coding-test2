package inaeinae.studycodingtest.PGS;

/**
 * [PGS] PCCP 기출문제_1번_붕대 감기 / lv1
 * (2023.12.26) https://school.programmers.co.kr/learn/courses/30/lessons/250137
 */
public class PGS_250137 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int userHealth = health;
        int healingTime = 0;
        int lastAttackTime = attacks[attacks.length-1][0];

        for (int time = 0; time <= lastAttackTime; time++) {
            int damage = getDamage(attacks, time);
            if (damage > 0) {
                userHealth -= damage;
                healingTime = 0;
            }
            if (damage == 0) {
                int[] healInfo = getHealInfo(bandage, healingTime, userHealth, health);
                healingTime = healInfo[0];
                userHealth += healInfo[1];
            }
            if (userHealth <= 0) {
                return -1;
            }
        }

        return userHealth;
    }

    public int getDamage(int[][] attacks, int time) {
        for (int[] attack : attacks) {
            if (time == attack[0]) {
                return attack[1];
            }
        }
        return 0;
    }

    public int[] getHealInfo(int[] bandage, int healingTime, int userHealth, int health) {
        int heal = bandage[1];
        healingTime++;
        if (bandage[0] == healingTime) {
            heal += bandage[2];
            healingTime = 0;
        }
        if (userHealth + heal > health) {
            heal = health - userHealth;
            healingTime = 0;
        }
        return new int[] {healingTime, heal};
    }
}
