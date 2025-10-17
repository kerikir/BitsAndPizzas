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
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


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
                var text = when (pizzaType) {
                    R.id.radio_divolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                }

                val parmesan = view.findViewById<Chip>(R.id.parmesan)
                // Выбрана плашка
                text += if (parmesan.isChecked) ", extra parmesan" else ""
                val chilioil = view.findViewById<Chip>(R.id.chili_oil)
                text += if (chilioil.isChecked) ", extra chili oil" else ""

                /* Сообщение Snackbar
                   Принимает: представление (инициирующее появление Snackbar), текст (CharSequence),
                   промежуток времени */
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }
}