package com.fis.xiaolu.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ServerApplication!
 *
 */
@SpringBootApplication
public class ServerApplication 
{
    public static void main( String[] args )
    {
        System.out.println( "ServerApplication start ......!" );
        SpringApplication.run(ServerApplication.class, args);
        System.out.println( "ServerApplication success ......!" );
        
    }
}
