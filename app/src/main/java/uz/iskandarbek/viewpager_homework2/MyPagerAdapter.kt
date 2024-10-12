package uz.iskandarbek.viewpager_homework2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class MyPagerAdapter : PagerAdapter() {
    override fun getCount(): Int = 4

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    @SuppressLint("MissingInflatedId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemPager =
            LayoutInflater.from(container.context).inflate(R.layout.item_pager, container, false)

        val itemBackround = itemPager.findViewById<ImageView>(R.id.imageClick)
        val tvTitle = itemPager.findViewById<TextView>(R.id.tv_title)
        val tvMessage = itemPager.findViewById<TextView>(R.id.tv_message)


        when (position) {

            0 -> {
                itemBackround.setImageResource(R.drawable.click1)
                tvTitle.text = "Click va Paymega o'tish xizmati"
                tvMessage.text =
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            }

            1 -> {
                itemBackround.setImageResource(R.drawable.click2)
                tvTitle.text = "Barcha operatorlar bo'yicha statistika"
                tvMessage.text =
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            }

            2 -> {
                itemBackround.setImageResource(R.drawable.click3)
                tvTitle.text = "Ta'riflarni filtirlash"
                tvMessage.text =
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            }

            3 -> {
                itemBackround.setImageResource(R.drawable.click4)
                tvTitle.text = "Yangi imkoniyatlar"
                tvMessage.text =
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            }
        }
        container.addView(itemPager)
        return itemPager
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}