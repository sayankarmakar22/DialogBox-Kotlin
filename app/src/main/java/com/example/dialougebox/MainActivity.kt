package com.example.dialougebox

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialougebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //simple alert box
        binding.button.setOnClickListener {

            var builder = AlertDialog.Builder(this)

            builder.setTitle("tussi ja rahe ho 😒")
            builder.setMessage("tussi na jao 😊")
            builder.setIcon(R.drawable.baseline_exit_to_app_24)
            builder.setPositiveButton("Yes ",DialogInterface.OnClickListener { dialog, which ->   finish()})
            builder.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->  })
            builder.show()

        }
        //alert box with single choice
        binding.button2.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            var lang = arrayOf("C++","Java","Python")
            builder.setTitle("Choose Your favourite language")
            builder.setSingleChoiceItems(lang,0,DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Your favorite language is : ${lang[which]}",Toast.LENGTH_LONG).show()
            })
            builder.setPositiveButton("Yes ",DialogInterface.OnClickListener { dialog, which ->  })
            builder.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->  })
            builder.show()
        }
        //alert box with multiple choice
        binding.button3.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            var lang = arrayOf("C++","Java","Python")
            builder.setTitle("Choose Your favourite language")
            builder.setMultiChoiceItems(lang,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"Your favorite language is : ${lang[which]}",Toast.LENGTH_LONG).show()
            })
            builder.setPositiveButton("Yes ",DialogInterface.OnClickListener { dialog, which ->  })
            builder.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->  })

            builder.show()
        }

        //customized alert box
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_alert)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alert_bg))

        var contactUs = dialog.findViewById<Button>(R.id.button5)
        var enjoy = dialog.findViewById<Button>(R.id.button6)

        contactUs.setOnClickListener {
            Toast.makeText(this,"Our agent will call you soon",Toast.LENGTH_SHORT).show()
        }
        enjoy.setOnClickListener {
            Toast.makeText(this,"Enjoy",Toast.LENGTH_SHORT).show()
        }

        binding.button4.setOnClickListener {
             dialog.show()
        }
    }
}