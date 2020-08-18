package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View as view

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }var lastdec= false
    var lastdig=false
    fun ondigit(view: view){
        tv.append((view as Button).text)
        lastdig=true
    }
fun onclr(view: view) {
    tv.text = " "
    lastdec=false
    lastdig=false

}
    fun ondec(view: view)
    {
        if(!lastdec && lastdig)
        {tv.append(".")
    lastdec=true
        lastdig=false}}
    fun opp(view: view){
          if(lastdig&&!isoperatoradded(tv.text.toString()))
          {
              tv.append((view as Button).text)
              lastdec=false
              lastdig=false
          }
    }
    private fun isoperatoradded(value: String): Boolean
    {return  if (value.startsWith("-")){
       false}
        else value.contains("/")||value.contains("-")||value.contains("*")||value.contains("+")

    }
    fun opequal(view: view){
        var tvvalue= tv.text.toString()
var prefix=""
        if (tvvalue.startsWith("-")){
            prefix="-"
            tvvalue=tvvalue.substring(1)
        }
        try{
          if (tvvalue.contains("-"))
          {val splitval = tvvalue.split("-")
          var a = splitval[0]
          var b = splitval[1]
              if(!prefix.isEmpty()){
                  a=prefix+a
              }
          tv.text = rem((a.toDouble() - b.toDouble()).toString())
      }else if (tvvalue.contains("+"))
          {val splitval = tvvalue.split("+")
              var a = splitval[0]
              var b = splitval[1]
              if(!prefix.isEmpty()){
                  a=prefix+a
              }
              tv.text = rem((a.toDouble() + b.toDouble()).toString())
          }
          else if (tvvalue.contains("*"))
          {val splitval = tvvalue.split("*")
              var a = splitval[0]
              var b = splitval[1]
              if(!prefix.isEmpty()){
                  a=prefix+a
              }
              tv.text = rem((a.toDouble() * b.toDouble()).toString())
          }else if (tvvalue.contains("/"))
          {val splitval = tvvalue.split("/")
              var a = splitval[0]
              var b = splitval[1]
              if(!prefix.isEmpty()){
                  a=prefix+a
              }
              tv.text = rem((a.toDouble() / b.toDouble()).toString())
          }}catch (e: ArithmeticException) {
            e.printStackTrace()
        }

    }
   private fun rem(values: String): String{
        var result = values
        if(result.contains(".0"))
        {
            result=result.substring(0,result.length-2)

        }
        return result
    }


}
