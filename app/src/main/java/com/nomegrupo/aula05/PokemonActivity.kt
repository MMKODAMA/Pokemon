package com.nomegrupo.aula05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.nomegrupo.aula05.databinding.ActivityContatoBinding
import com.nomegrupo.aula05.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {
    lateinit var binding: ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemons  = arrayListOf("Escolha Um Pokemon","Charmander","Squirtle","Bulbassauro")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,pokemons)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapter: AdapterView<*>?, spinner: View?, posicao: Int, id: Long) {

                when(posicao){

                    1->{
                        val imagemCharmander = getDrawable(R.drawable.charmander)
                        binding.imageView.setImageDrawable(imagemCharmander)
                    }
                    2->{
                        val imagemSquirtle = getDrawable(R.drawable.squirtle)
                        binding.imageView.setImageDrawable(imagemSquirtle)
                    }
                    3->{
                        val imagemBulbassauro = getDrawable(R.drawable.bulbassauro)
                        binding.imageView.setImageDrawable(imagemBulbassauro)
                    }
                    else -> binding.imageView.setImageDrawable(null)


                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


        binding.button.setOnClickListener {
            when(binding.spinner.selectedItemPosition){

                1-> alert("Charmander","Tipo: Fire",this)

                2-> alert("Squirtle","Tipo:Water",this)

                3-> alert("Bulbassauro","Tipo: Grass / Poison",this)

            }
        }
    }
}