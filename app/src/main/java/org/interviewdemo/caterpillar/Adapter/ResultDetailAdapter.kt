package org.interviewdemo.caterpillar.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.item_results.view.*
import org.interviewdemo.caterpillar.Data.Result
import org.interviewdemo.caterpillar.R

/*Result Detail Adapter
1.Class take the argument of context to inflate the item views

 */
class ResultDetailAdapter(private val context:Context):BaseAdapter() {

   var resultDetails=listOf<Result>()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val resultView:View
        val resultHolder:ViewHolder

        if(view==null)
        {
            resultView= LayoutInflater.from(context).inflate(R.layout.item_results,parent,false)
            resultHolder=ViewHolder(resultView)
            resultView.tag=resultHolder
        }
        else
        {
            resultHolder=view.tag as ViewHolder
            resultView=view

        }
        //Bind values to the view
        resultHolder.bind(resultDetails[position])

        return resultView
    }

    override fun getItem(position: Int)=resultDetails[position]

    override fun getItemId(position: Int)=resultDetails[position].id

    override fun getCount()=resultDetails.size


    //View holder class hold reference to item view, which can referenced while binding
    class ViewHolder(view:View){

        var id=view.txtResultId
        var name=view.txtResultName
        var description=view.txtResultDesc
        var dailyRate=view.txtResultDailyRate
        var weeklyRate=view.txtResultWklyRate
        var monthlyRate=view.txtMonthlyRate
        var operatedRates=view.txtResultOperatedRate

        fun bind(resultDetail:Result){

            id.text=resultDetail.id.toString()
            name.text=resultDetail.name
            description.text=resultDetail.description
            dailyRate.text=resultDetail.daily_rate
            weeklyRate.text=resultDetail.weekly_rate
            monthlyRate.text=resultDetail.monthly_rate
            operatedRates.text=resultDetail.operated_rates

        }



    }
}