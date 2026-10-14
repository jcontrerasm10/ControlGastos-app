package umg.edu.gt.controlgastos

import edu.umg.programacion2.gastos.datos.GastoRepositoryEnMemoria
import edu.umg.programacion2.gastos.servicio.ControlGastos

/** Un solo ControlGastos compartido por toda la app. */
object Dependencias {
    val control = ControlGastos(GastoRepositoryEnMemoria())
}