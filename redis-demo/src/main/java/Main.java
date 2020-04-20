import redis.clients.jedis.Jedis;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        Jedis jedis = new Jedis();

        jedis.set("name", new Integer(2).toString());
        System.out.println(jedis.get("name"));

        jedis.set("name", new Integer(3).toString());
        System.out.println(jedis.get("name"));

        jedis.incr("name");
        System.out.println(jedis.get("name"));

        //Set
        jedis.sadd("nicknames", "nickname#1");
        jedis.sadd("nicknames", "nickname#2");
        jedis.sadd("nicknames", "nickname#1");

        Set<String> nicknames = jedis.smembers("nicknames");
        for (String name : nicknames
             ) {
            System.out.println(name);
        }
        System.out.println(nicknames.size());



    }
}
