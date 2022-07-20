package com.example.notodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.util.SparseBooleanArray
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init the array list and the adapter
        val items = arrayListOf<String>()
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_multiple_choice, items)


        val add = findViewById<Button>(R.id.add);
        val remove = findViewById<Button>(R.id.remove);
        val clear = findViewById<Button>(R.id.clear);
        val textEdit = findViewById<EditText>(R.id.editText);
        val viewList = findViewById<ListView>(R.id.listView);

        add.setOnClickListener {
            items.add(textEdit.text.toString())
            viewList.adapter = adapter;
            adapter.notifyDataSetChanged()
            textEdit.text.clear()
        }

        remove.setOnClickListener {
            val position: SparseBooleanArray = viewList.checkedItemPositions;
            val count = viewList.count;
            var item = count - 1;
            while (item >= 0) {
                if (position.get(item)) {
                    adapter.remove(items[item]);
                }
                item--;
            }
            position.clear();
            adapter.notifyDataSetChanged();
        }

        clear.setOnClickListener {
            items.clear();
            adapter.notifyDataSetChanged();
        }

    }
}