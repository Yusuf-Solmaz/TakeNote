package com.yusuf.takenote.db

import java.io.Serializable

data class Note(val id: Int, val lesson: String, val point1:Int, val point2:Int) : Serializable