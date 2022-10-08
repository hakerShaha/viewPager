package uz.ilhomjon.viewpagertablayouttwo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import uz.ilhomjon.viewpagertablayouttwo.adapter.MyFragmentPagerAdapter
import uz.ilhomjon.viewpagertablayouttwo.databinding.ActivityMainBinding
import uz.ilhomjon.viewpagertablayouttwo.models.Data

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var arraList: ArrayList<Data>
    private lateinit var myFragmentPagerAdapter: MyFragmentPagerAdapter
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        arraList = ArrayList()

        arraList.add(
            Data(
                R.drawable.photo1.toString(),
                " Xush kelibsiz",
                "Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘, \n" +
                        "Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig‘"
            )
        )
        arraList.add(
            Data(
                R.drawable.photo2.toString(),
                "Hikoyalar dunyosi",
                "Gar zamonni nayf qilsam ayb qilma, ey rafiq, \n" +
                        "Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ !"
            )
        )
        arraList.add(
            Data(
                R.drawable.photo3.toString(),
                "Kitob ortidan",
                "Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n" +
                        " Kelmadi jonimg'a hech oromi jondin yaxshilig'."
            )
        )
        arraList.add(
            Data(
                R.drawable.photo4.toString(),
                "Bizga qoshiling",
                "Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n" +
                        " Emdi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'"
            )
        )

        myFragmentPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager, arraList)
        binding.viewpager.adapter = myFragmentPagerAdapter
        binding.dotsIndicator.attachTo(binding.viewpager)

        binding.viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
                index = position

                if (position == 3) {
                    binding.dale.visibility = View.INVISIBLE
                } else {
                    binding.dale.visibility = View.VISIBLE
                }
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })



        binding.skip.setOnClickListener {
            when (index) {
                0 -> {
                    binding.viewpager.currentItem = index + 4
                }
                1 -> {
                    binding.viewpager.currentItem = index + 3
                }
                2 -> {
                    binding.viewpager.currentItem = index + 2
                }
                3 -> {
                    binding.viewpager.currentItem = index + 1
                }
            }
        }
        binding.dale.setOnClickListener {
            when (index) {
                0 -> {
                    binding.viewpager.currentItem = index + 1
                }
                1 -> {
                    binding.viewpager.currentItem = index + 1
                }
                2 -> {
                    binding.viewpager.currentItem = index + 1
                }
                3 -> {
                    binding.viewpager.currentItem = index + 1

                }
                4 -> {
                    binding.dotsIndicator.setOnClickListener {

                    }
                }
            }
        }


    }
}