package buy.coke.zet.common.designsystem.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import buy.coke.zet.common.databinding.LayoutLongDialogBinding

class LongDialog(
    context: Context,
    private val yesButtonListener: (() -> Unit)? = null,
    private val noButtonListener: (() -> Unit)? = null,
    private val yesButtonText: String? = null,
    private val noButtonText: String? = null,
    private val warning: String? = null,
    private val title: String? = null
): Dialog(context) {
    private val binding: LayoutLongDialogBinding = LayoutLongDialogBinding.inflate(LayoutInflater.from(context))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        binding.okayButton.clickListener = View.OnClickListener {
            yesButtonListener?.let { invoke -> invoke() }
            dismiss()
        }

        binding.cancelButton.clickListener = View.OnClickListener {
            noButtonListener?.let { invoke -> invoke() }
            dismiss()
        }

        yesButtonText?.let { binding.okayButton.buttonText = it }
        noButtonText?.let { binding.cancelButton.buttonText = it }
        warning?.let { binding.dialogWarning.text = it } ?: kotlin.run { binding.dialogWarning.visibility = View.GONE }
        title?.let { binding.dialogTitle.text = it }
    }
}
