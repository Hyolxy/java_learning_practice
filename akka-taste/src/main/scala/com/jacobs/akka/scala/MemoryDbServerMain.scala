package com.jacobs.akka.scala

import akka.actor.{ActorSystem, Props}
import com.jacobs.akka.memorydb.{MemDbClient, MemDbServer}

/**
  * @author lichao <lichao@kuaishou.com>
  *         Created on 2019-05-18
  *
  *         启动
  */
object MemoryDbServerMain extends App {
  val system = ActorSystem("akkaMemoryDb")
  val server = system.actorOf(Props[MemDbServer], name = "akka-memory-db")

  //客户端操作
  val client = new MemDbClient(server)
  client.set("test1", "value1")
  client.set("test2", "value2")

  client.get("test1").thenAccept(x => println(s"test1 is ${x}"))
  client.get("test2").thenAccept(x => println(s"test2 is ${x}"))
}
