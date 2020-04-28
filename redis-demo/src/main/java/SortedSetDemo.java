import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Iterator;
import java.util.Set;

public class SortedSetDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();

        jedis.zadd("2020010100", 1.0, "kane");
        jedis.zadd("2020010100", 1.0, "luke");
        jedis.zincrby("2020010100", 1.0, "luke");

        jedis.zadd("2020010101", 1.0, "kane");
        jedis.zadd("2020010101", 1.0, "luke");
        jedis.zincrby("2020010101", 1.0, "luke");

        jedis.zadd("2020010102", 1.0, "kane");
        jedis.zadd("2020010102", 1.0, "luke");
        jedis.zincrby("2020010102", 1.0, "luke");

        System.out.println("number in 2020010100:" + jedis.zcard("2020010100"));

        Set<String> rankList = jedis.zrevrange("2020010100", 0, 2);
        rankList.forEach(System.out::println);


        Set<Tuple> rankListWithScores = jedis.zrevrangeWithScores("2020010100", 0, 2);

        for (Tuple t: rankListWithScores
             ) {
            System.out.println(t.getElement()+":"+t.getScore());
        }


        long ret = jedis.zunionstore("20200101", "2020010100", "2020010101", "2020010102");
        System.out.println("zunin ret:"+ ret);

        System.out.println("zcard:"+jedis.zcard("20200101"));


        Set<Tuple> dayRankList = jedis.zrevrangeWithScores("20200101", 0, 2);

        for (Tuple t: dayRankList
        ) {
            System.out.println(t.getElement()+":"+t.getScore());
        }
    }
}
