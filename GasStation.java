// 134. Gas Station

public class GasStation {

    // 思路是贪心算法
    // totalGas表示，所有加油站的油量综合
    // totalCost，是到达所有加油站的消耗
    // tank是车内的油量，每次到达一个新的加油站
    // gas[i] - cost[i]含义是，用这个站的油量减去到达下一站的消耗，和目前车内的油量相加
    // 如果结果大于等于0，说明可以到达下一站
    // 如果小于0，说明不能到达下一站，那么 start 到 i 之间的每一站，都不能作为起点
    // 将start设为i+1, 油量置0
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int tank = 0, start = 0;

        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0) {
                start = i+1;
                tank = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }

}
