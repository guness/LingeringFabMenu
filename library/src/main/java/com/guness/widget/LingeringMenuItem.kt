package com.guness.widget

import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.*
import android.widget.ImageView
import com.guness.widget.LingeringFabMenu.Companion.TAG

/**
 * Created by guness on 25.01.2018.
 */
class LingeringMenuItem(parent: ViewGroup) : MenuItem {

    private var mOrder = -1

    private val mContext = parent.context
    private val mItem: View
    private val mIcon: ImageView

    private var mListener: MenuItem.OnMenuItemClickListener? = null
    private var mTitle: CharSequence? = null

    init {
        mItem = LayoutInflater.from(mContext).inflate(R.layout.lingering_menu_item, parent, false)
        mIcon = mItem.findViewById(R.id.lingeringMenuIcon)
        mItem.setOnClickListener {
            mListener?.onMenuItemClick(this)
        }
    }

    fun getView(): View {
        return mItem
    }

    override fun expandActionView(): Boolean {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun hasSubMenu(): Boolean {
        return false
    }

    override fun getMenuInfo(): ContextMenu.ContextMenuInfo {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getItemId(): Int {
        return mItem.id
    }

    fun setItemId(id: Int): LingeringMenuItem {
        mItem.id = id
        return this
    }

    override fun getAlphabeticShortcut(): Char {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setEnabled(enabled: Boolean): LingeringMenuItem {
        mItem.isEnabled = enabled
        return this
    }

    override fun setTitle(title: CharSequence?): LingeringMenuItem {
        mTitle = title
        return this
    }

    override fun setTitle(title: Int): LingeringMenuItem {
        mTitle = mContext.getString(title)
        return this
    }

    override fun setChecked(checked: Boolean): LingeringMenuItem {
        Log.w(TAG, "LingeringFabMenu does not support this feature: setChecked")
        return this
    }

    override fun getActionView(): View {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getTitle(): CharSequence {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getOrder(): Int {
        return mOrder
    }

    fun setOrder(order: Int): LingeringMenuItem {
        mOrder = order
        return this
    }

    override fun setOnActionExpandListener(listener: MenuItem.OnActionExpandListener?): LingeringMenuItem {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getIntent(): Intent {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setVisible(visible: Boolean): LingeringMenuItem {
        mItem.visibility = if (visible) {
            View.VISIBLE
        } else {
            View.GONE
        }
        return this
    }

    override fun isEnabled(): Boolean {
        return mItem.isEnabled
    }

    override fun isCheckable(): Boolean {
        return false
    }

    override fun setShowAsAction(actionEnum: Int) {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getGroupId(): Int {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setActionProvider(actionProvider: ActionProvider?): LingeringMenuItem {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setTitleCondensed(title: CharSequence?): LingeringMenuItem {
        Log.w(TAG, "LingeringFabMenu does not support this feature: setTitleCondensed")
        return this
    }

    override fun getNumericShortcut(): Char {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun isActionViewExpanded(): Boolean {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun collapseActionView(): Boolean {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun isVisible(): Boolean {
        return mItem.visibility == View.VISIBLE
    }

    override fun setNumericShortcut(numericChar: Char): LingeringMenuItem {
        Log.w(TAG, "LingeringFabMenu does not support this feature: setNumericShortcut")
        return this
    }

    override fun setActionView(view: View?): LingeringMenuItem {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setActionView(resId: Int): LingeringMenuItem {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setAlphabeticShortcut(alphaChar: Char): LingeringMenuItem {
        Log.w(TAG, "LingeringFabMenu does not support this feature: setAlphabeticShortcut")
        return this
    }

    override fun setIcon(icon: Drawable?): LingeringMenuItem {
        mIcon.setImageDrawable(icon)
        return this
    }

    override fun setIcon(iconRes: Int): LingeringMenuItem {
        mIcon.setImageResource(iconRes)
        return this
    }

    override fun isChecked(): Boolean {
        return false
    }

    override fun setIntent(intent: Intent?): LingeringMenuItem {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setShortcut(numericChar: Char, alphaChar: Char): LingeringMenuItem {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getIcon(): Drawable {
        return mIcon.drawable
    }

    override fun setShowAsActionFlags(actionEnum: Int): LingeringMenuItem {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setOnMenuItemClickListener(listener: MenuItem.OnMenuItemClickListener?): LingeringMenuItem {
        mListener = listener
        return this
    }

    override fun getActionProvider(): ActionProvider {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setCheckable(checkable: Boolean): LingeringMenuItem {
        Log.w(TAG, "LingeringFabMenu does not support this feature: setCheckable")
        return this
    }

    override fun getSubMenu(): SubMenu {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getTitleCondensed(): CharSequence {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }
}