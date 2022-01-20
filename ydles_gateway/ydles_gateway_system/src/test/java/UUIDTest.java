import java.util.UUID;

/**
 * Project Name: ydles_parent
 * File Name: UUIDTest
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/19/下午 3:08
 * Copyright (c) 2022,
 */
public class UUIDTest {
    public static void main(String[] args) {

        for (int i = 0; i <10 ; i++) {
            String s= UUID.randomUUID().toString();   System.out.println(s);
        }

    }
}
