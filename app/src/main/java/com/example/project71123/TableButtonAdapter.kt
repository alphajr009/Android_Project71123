import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.project71123.R
import com.example.project71123.Table

class TableButtonAdapter(
    private val context: Context,
    private val tableList: List<Table>
) : RecyclerView.Adapter<TableButtonAdapter.ViewHolder>() {

    var tableItemClickListener: OnTableItemClickListener? = null

    interface OnTableItemClickListener {
        fun onTableItemClick(table: Table)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tableLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.tablebutton, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val table = tableList[position]

        holder.tableLayout.setOnClickListener {
            tableItemClickListener?.onTableItemClick(table)
        }

        // Set text for textView and textView4
        holder.tableLayout.findViewById<TextView>(R.id.textView).text = table.tableName

        val lastServiceTextView = holder.tableLayout.findViewById<TextView>(R.id.textView4)
        lastServiceTextView.text = when (table.tableName) {
            "Table 1" -> "Last Service"
            "Table 2" -> "Empty"
            "Table 3" -> "Waiting for Bill"
            "Table 4" -> "Bill Sent"
            else -> "Unknown"
        }

        // Set text color based on conditions
        val colorResId = when (lastServiceTextView.text) {
            "Last Service" -> R.color.btn_green
            "Empty" -> R.color.btn_white
            "Waiting for Bill" -> R.color.btn_red
            "Bill Sent" -> R.color.btn_green
            else -> R.color.btn_white
        }

        lastServiceTextView.setTextColor(ContextCompat.getColor(context, colorResId))
    }

    override fun getItemCount(): Int {
        return tableList.size
    }
}