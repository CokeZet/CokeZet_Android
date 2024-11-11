package buy.coke.zet.common.designsystem.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import buy.coke.zet.common.databinding.LayoutShortDialogBinding

class ShortDialog(context: Context): Dialog(context) {
    private val binding: LayoutShortDialogBinding = LayoutShortDialogBinding.inflate(LayoutInflater.from(context))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        binding.cancelButton.clickListener = View.OnClickListener { dismiss() }
        binding.okayButton.clickListener = View.OnClickListener { dismiss() }
    }
}