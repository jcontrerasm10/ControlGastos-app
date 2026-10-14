package umg.edu.gt.controlgastos

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.umg.programacion2.gastos.modelo.Gasto
import edu.umg.programacion2.gastos.servicio.formatearQuetzales
import umg.edu.gt.controlgastos.databinding.ItemGastoBinding

class GastoAdapter(
    private val alTocarGasto: (Gasto) -> Unit
) : RecyclerView.Adapter<GastoAdapter.GastoViewHolder>() {

    private var gastos: List<Gasto> = emptyList()

    class GastoViewHolder(val binding: ItemGastoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = gastos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastoViewHolder {
        val binding = ItemGastoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GastoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GastoViewHolder, position: Int) {
        val gasto = gastos[position]
        holder.binding.tvDescripcion.text = gasto.descripcion
        holder.binding.tvDetalle.text = "${gasto.categoria} · ${gasto.fecha}"
        holder.binding.tvMonto.text = formatearQuetzales(gasto.monto)
        holder.binding.root.setOnClickListener { alTocarGasto(gasto) }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun mostrar(nuevos: List<Gasto>) {
        gastos = nuevos
        notifyDataSetChanged()
    }
}