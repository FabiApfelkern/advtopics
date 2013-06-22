package advtopics.trendcloud.controller

import advtopics.trendcloud.controller.interfaces.Request

class SimpleRequest (Name: String) extends Request {
    def getName: String = Name
}