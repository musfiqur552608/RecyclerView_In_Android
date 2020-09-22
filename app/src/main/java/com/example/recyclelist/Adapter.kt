package com.example.recyclelist

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(data:ArrayList<Person>,internal var context: Context): RecyclerView.Adapter<Adapter.ViewHoler>(){

    internal var data:List<Person>

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false)

        return ViewHoler(layout)
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.name.text = data[position].name
        holder.image.setImageResource(data[position].image)

        holder.card.setOnClickListener {
            val alert = Dialog(context)
            alert.setContentView(R.layout.alert)
            alert.window?.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT)

            alert.setTitle("Person")

            val name = alert.findViewById<TextView>(R.id.alert_name)
            val desc = alert.findViewById<TextView>(R.id.alert_desc)
            val number = alert.findViewById<TextView>(R.id.alert_phn)
            val image = alert.findViewById<CircleImageView>(R.id.alert_image)
            val call = alert.findViewById<Button>(R.id.alert_call)

            name.text = data[position].name
            desc.text = data[position].desc
            number.text = data[position].phonenumber
            image.setImageResource(data[position].image)

            alert.show()

            call.setOnClickListener {

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",data[position].phonenumber,null))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(context,intent,null)
                alert.dismiss()
            }

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHoler(itemView:View): RecyclerView.ViewHolder(itemView){

        internal var name:TextView
        internal var image:ImageView

        internal var card:CardView

        init {
            name = itemView.findViewById(R.id.person_name)
            image = itemView.findViewById(R.id.person_image)
            card = itemView.findViewById(R.id.card)
        }
    }
}