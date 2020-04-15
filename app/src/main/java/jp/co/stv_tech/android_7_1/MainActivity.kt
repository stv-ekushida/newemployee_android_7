package jp.co.stv_tech.android_7_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycle", "Main OnCreate called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()

        var menu = mutableMapOf<String, String>("name" to "唐揚げ定食",
                "price" to "800円")
        menuList.add(menu)

        menu = mutableMapOf<String, String>("name" to "ハンバーグ定食",
        "price" to "850円")
        menuList.add(menu)

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(applicationContext,
                menuList,
                android.R.layout.simple_list_item_2,
                from,
                to)
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListner()
    }

    public override fun onStart() {
        Log.i("LifeCycle", "Main onStart called")
        super.onStart()
    }

    public override fun onRestart() {
        Log.i("LifeCycle", "Main onReStart called")
        super.onRestart()
    }

    public override fun onResume() {
        Log.i("LifeCycle", "Main onResume called")
        super.onResume()
    }

    public override fun onPause() {
        Log.i("LifeCycle", "Main onPause called")
        super.onPause()
    }

    public override fun onStop() {
        Log.i("LifeCycle", "Main onStop called")
        super.onStop()
    }

    public override fun onDestroy() {
        Log.i("LifeCycle", "Main onDestory called")
        super.onDestroy()
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>,
                                 view: View?,
                                 position: Int,
                                 id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>

            Log.i("Event", "Main onItemClick called")
            Log.i("Event", position.toString())

            val menuName = item["name"]
            val menuPrice = item["price"]

            Log.i("Event", "menuName" + menuName)
            Log.i("Event", "menuPrice" + menuPrice)
            
            val intent = Intent(applicationContext, MenuThanksActivity::class.java)

            //引数を渡す
            intent.putExtra("menuName", menuName)
            intent.putExtra("menuPrice", menuPrice)

             startActivity(intent)
        }
    }
}
