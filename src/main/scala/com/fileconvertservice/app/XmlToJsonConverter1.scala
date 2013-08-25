package com.fileconvertservice.app

import org.json4s.Xml.toJson
import org.json4s.jackson._

object XmlToJsonConverter1 extends App{

  val xml1 =
    <users>
      <user>
        <id>1</id>
        <name>Harry</name>
      </user>
      <user>
        <id>2</id>
        <name>David</name>
      </user>
    </users>
  val json = toJson(xml1)
  println(prettyJson(renderJValue(json)))
}
