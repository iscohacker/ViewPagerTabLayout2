package uz.iskandarbek.viewpager_homework2

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import uz.iskandarbek.viewpager_homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myPagerAdapter: MyPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        myPagerAdapter = MyPagerAdapter()
        binding.viewPager.adapter = myPagerAdapter

        binding.myTab.setupWithViewPager(binding.viewPager)
        binding.nextTv.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            if (currentItem < myPagerAdapter.count - 1) {
                binding.viewPager.currentItem = currentItem + 1
            }
        }
        binding.next2.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            if (currentItem < myPagerAdapter.count - 1) {
                binding.viewPager.currentItem = currentItem + 1
            }
        }
        binding.skipTv.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            if (currentItem < myPagerAdapter.count - 1) {
                binding.viewPager.currentItem = currentItem + 4
            }
        }
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == myPagerAdapter.count - 1) {
                    binding.nextTv.visibility = View.INVISIBLE
                    binding.next2.visibility = View.INVISIBLE
                } else {
                    binding.nextTv.visibility = View.VISIBLE
                    binding.next2.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        setTabLayout()
    }

    fun setTabLayout() {
        val tabCount = binding.myTab.tabCount

        for (i in 0 until tabCount) {
            val tabItem = layoutInflater.inflate(R.layout.item_tab, null, false)
            val tabView = binding.myTab.getTabAt(i)
            tabView?.customView = tabItem

            val selected = tabItem.findViewById<ImageView>(R.id.selectedd)
            val unselected = tabItem.findViewById<ImageView>(R.id.unselectedd)

            if (i == 0) {
                selected.visibility = View.VISIBLE
                unselected.visibility = View.INVISIBLE
            } else {
                selected.visibility = View.INVISIBLE
                unselected.visibility = View.VISIBLE
            }
        }

        binding.myTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val selectIndicator: View = tab?.customView!!
                selectIndicator.findViewById<ImageView>(R.id.selectedd).visibility = View.VISIBLE
                selectIndicator.findViewById<ImageView>(R.id.unselectedd).visibility =
                    View.INVISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val selectIndicator: View = tab?.customView!!
                selectIndicator.findViewById<ImageView>(R.id.unselectedd).visibility = View.VISIBLE
                selectIndicator.findViewById<ImageView>(R.id.selectedd).visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

}