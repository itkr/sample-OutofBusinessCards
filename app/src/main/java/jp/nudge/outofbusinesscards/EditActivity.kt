package jp.nudge.outofbusinesscards

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

//        val pref = PreferenceManager.getDefaultSharedPreferences(this)
//        val company = pref.getString("company", "")
        val pref = PreferenceManager.getDefaultSharedPreferences(this).apply {
            val company = getString("company", "")
        }

        saveBtn.setOnClickListener(){
            saveData()
            finish()
        }
        cancelBtn.setOnClickListener(){
            finish()
        }
    }

    private fun saveData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("company", companyEdit.text.toString())
        editor.apply()
    }
}