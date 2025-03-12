package com.example.lab5

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Dialog Title")
            .setMessage("This is a sample dialog.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()
    }
}