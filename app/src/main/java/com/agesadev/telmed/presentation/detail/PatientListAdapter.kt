package com.agesadev.telmed.presentation.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.agesadev.telmed.core.ItemClick
import com.agesadev.telmed.core.returnPatientAge
import com.agesadev.telmed.databinding.SinglePatientItemBinding
import com.agesadev.telmed.domain.model.Patient
import java.util.*

class PatientListAdapter(private val onPatientClicked: ItemClick) :
    ListAdapter<Patient, PatientListAdapter.PatientViewHolder>(patientDiffUtilCallback) {

    inner class PatientViewHolder(private val binding: SinglePatientItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        @SuppressLint("SetTextI18n")
        fun bind(patient: Patient) {
            binding.apply {
                patientName.text = "${patient.first_name} ${patient.last_name}"
                //calulate the age of the patient from the date of birth and current time
                ageText.text = patient.date_of_birth
//                ageText.text = patient.toString()
                viewMoreChip.setOnClickListener(this@PatientViewHolder)
            }
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onPatientClicked.onPatientClick(getItem(adapterPosition))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        return PatientViewHolder(
            SinglePatientItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }


}

val patientDiffUtilCallback = object : DiffUtil.ItemCallback<Patient>() {
    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem == newItem
    }

}


