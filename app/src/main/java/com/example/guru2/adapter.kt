package com.example.guru2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//초기 데이터 형태. myDataset=  각 줄마다 보여줄 값을 들고 있는 원본 데이터(여기선 스트링 형)
class adapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<adapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.

    //class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    // 뷰(한 줄) 안의 요소를 찾아가는 클래스
    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var textViewname: TextView? = null
        var textViewreview: TextView? = null
        var communityphoto: ImageView? = null

        init {
            textViewname = v.findViewById(R.id.textViewname)
            textViewreview = v.findViewById(R.id.textViewreview)
            communityphoto = v.findViewById(R.id.communityphoto)
        }
    }
    // Create new views (invoked by the layout manager)
    // recyclerview 의 항목화면 연결 해주는 함수
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): adapter.MyViewHolder {
        // create a new view
        val linearLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_post, parent, false) as TextView
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(linearLayout)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textViewname?.text = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}