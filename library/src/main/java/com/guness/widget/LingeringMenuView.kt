package com.guness.widget

import android.annotation.TargetApi
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.AttributeSet
import android.view.*
import android.widget.LinearLayout
import java.util.*

/**
 * Created by guness on 25.01.2018.
 */
class LingeringMenuView : LinearLayout, Menu {

    private val mItems = LinkedList<LingeringMenuItem>()
    private var mListener: MenuItem.OnMenuItemClickListener? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun clear() {
        mItems.clear()
        removeAllViews()
    }

    override fun removeItem(id: Int) {
        val item = mItems.find { it.itemId == id }
        if (item != null) {
            mItems.remove(item)
            removeView(item.getView())
        }
    }

    override fun setGroupCheckable(group: Int, checkable: Boolean, exclusive: Boolean) {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun performIdentifierAction(id: Int, flags: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setGroupEnabled(group: Int, enabled: Boolean) {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun getItem(index: Int): MenuItem {
        return mItems[index]
    }

    override fun performShortcut(keyCode: Int, event: KeyEvent?, flags: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeGroup(groupId: Int) {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun setGroupVisible(group: Int, visible: Boolean) {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun add(title: CharSequence?): MenuItem {
        val item = LingeringMenuItem(this)
                .setTitle(title)
                .setOnMenuItemClickListener(mListener)
        mItems.add(item)
        addView(item.getView())
        return item
    }

    override fun add(titleRes: Int): MenuItem {
        val item = LingeringMenuItem(this)
                .setTitle(titleRes)
                .setOnMenuItemClickListener(mListener)
        mItems.add(item)
        addView(item.getView())
        return item
    }

    override fun add(groupId: Int, itemId: Int, order: Int, title: CharSequence?): MenuItem {
        val item = LingeringMenuItem(this)
                .setItemId(itemId)
                .setOrder(order)
                .setTitle(title)
                .setOnMenuItemClickListener(mListener)
        mItems.add(item)
        addView(item.getView())
        return item
    }

    override fun add(groupId: Int, itemId: Int, order: Int, titleRes: Int): MenuItem {
        val item = LingeringMenuItem(this)
                .setItemId(itemId)
                .setOrder(order)
                .setTitle(titleRes)
                .setOnMenuItemClickListener(mListener)
        mItems.add(item)
        addView(item.getView())
        return item
    }

    fun setOnMenuItemClickListener(listener: MenuItem.OnMenuItemClickListener?) {
        mListener = listener
        mItems.forEach { it.setOnMenuItemClickListener(listener) }
    }

    override fun isShortcutKey(keyCode: Int, event: KeyEvent?): Boolean {
        return false
    }

    override fun setQwertyMode(isQwerty: Boolean) {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun hasVisibleItems(): Boolean {
        return true
    }

    override fun addSubMenu(title: CharSequence?): SubMenu {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun addSubMenu(titleRes: Int): SubMenu {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun addSubMenu(groupId: Int, itemId: Int, order: Int, title: CharSequence?): SubMenu {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun addSubMenu(groupId: Int, itemId: Int, order: Int, titleRes: Int): SubMenu {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun addIntentOptions(groupId: Int, itemId: Int, order: Int, caller: ComponentName?, specifics: Array<out Intent>?, intent: Intent?, flags: Int, outSpecificItems: Array<out MenuItem>?): Int {
        throw UnsupportedOperationException("LingeringFabMenu does not support this feature")
    }

    override fun findItem(id: Int): MenuItem? {
        return mItems.find { it.itemId == id }
    }

    override fun size(): Int {
        return mItems.size
    }

    override fun close() {
        visibility = View.INVISIBLE
    }
}