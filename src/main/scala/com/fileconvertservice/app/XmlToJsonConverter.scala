package com.fileconvertservice.app

import io.Source
import org.json4s.Xml._
import org.json4s.jackson._
import xml.XML
import java.io.File

object XmlToJsonConverter {

  def convert(xmlDownloadUrl: String):String = {
    val html = Source.fromURL(xmlDownloadUrl)
    val json = toJson(XML.loadString(html.mkString))
    println(prettyJson(renderJValue(json)))
    val fileName = xmlDownloadUrl.split("/").last.split("&")(0)
    println(getClass.getResource("/"))
    println(getClass.getResource("/files"))
    println(getClass.getResource("webapp"))
    writeToFile("webapp/files/converted/"+fileName.replace(".xml", ".json"), compactJson(renderJValue(json)))
    ""
  }

  def writeToFile(fileName: String, fileContent: String) {
    val pw = new java.io.PrintWriter(new File(fileName))
    try {
      pw.write(fileContent)
    } finally {
      pw.close()
    }
  }

}
