package com.hfad.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton


class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        // Использование панели инструментов как панели приложения
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {

            val pizzaGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
            // Получение id выбранного переключателя
            val pizzaType = pizzaGroup.checkedRadioButtonId

            // Пицца не выбрана
            if (pizzaType == -1) {
                val text = "You need to choose a pizza type"
                /* Отображение простого всплывающего сообщения
                   Принимает: context, сообщение (CharSequence) и длительность */
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            } else {

            }
        }

        return view
    }
}