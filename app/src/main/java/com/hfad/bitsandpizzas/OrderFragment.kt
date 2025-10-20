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
// Импортируем класс связывания
import com.hfad.bitsandpizzas.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    /** Первый доступ к представлениям фрагмента.
     *  Активности требуется доступ к макету фрагмента. */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Получаем объект Fragment Order Binding связанный с макетом фрагмента
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root

        // Использование панели инструментов как панели приложения
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {

            // Получение id выбранного переключателя
            val pizzaType = binding.pizzaGroup.checkedRadioButtonId

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

                // Выбрана плашка
                text += if (binding.parmesan.isChecked) ", extra parmesan" else ""
                text += if (binding.chiliOil.isChecked) ", extra chili oil" else ""

                /* Сообщение Snackbar
                   Принимает: представление (инициирующее появление Snackbar), текст (CharSequence),
                   промежуток времени */
                Snackbar.make(binding.fab, text, Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }


    /** Иерархия фрагмента готовится к уничтожению.
     *  Макет фрагмента становится ненужным для активности. */
    override fun onDestroyView() {
        super.onDestroyView()
        // Нельзя обращаться к представлениям
        _binding = null
    }
}