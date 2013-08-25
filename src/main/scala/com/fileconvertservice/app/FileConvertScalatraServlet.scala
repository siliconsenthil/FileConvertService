package com.fileconvertservice.app

import org.json4s.{DefaultFormats, Formats}
import org.json4s.jackson.Serialization.write

class FileConvertScalatraServlet extends FileconvertserviceStack {
  protected implicit val jsonFormats: Formats = DefaultFormats.withBigDecimal

  get("/convert") {
    contentType = "text/json"
    if(params("file_name").contains("_success")){
      println(write(Map("status" -> "success", "url" -> "http://fileconvertservice.herokuapp.com/files/converted/sample.json")))
      write(Map("status" -> "success", "url" -> "http://fileconvertservice.herokuapp.com/files/converted/sample.json"))
    }else {
      println(write(Map("status" -> "inprogress")))
      write(Map("status" -> "inprogress"))
    }
  }
}
