package uz.ilhomjon.viewpagertablayouttwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        arraList.add(Data(R.drawable.uch.toString(),
            " Geoaxborot",
            "Geoaxborot moduli orqali siz o'zingizga yaqin bo'lgan migrantlar va boshqa muassasalar haqida ma'lumot olishingiz mumkin"))
        arraList.add(Data(R.drawable.bir.toString(),
            "Huquqiy axborot",
            "Huquqiy axborot moduli orqali siz migratsiya sohasiga oid yangiliklardan, qonunlardan xabardor bo'lishingiz va online konsultatsiya olishingiz mumkin"))
        arraList.add(Data(R.drawable.tort.toString(),
            " To'lovlar xizmatlari",
            "To'lov xizmatlari moduli orqali siz masofadan turib turli xil xizmatlarga to'lovlar haqida ma'lumot olishingiz va to'lovlarni amalga oshirishingiz mumkin"))
        arraList.add(Data(R.drawable.ikki.toString(),
            "Qo'shimcha imkoniyat",
            "Qo'shimcha imkoniyatlar moduli orqali siz interaktiv so'zlashgichlar va lug'atlar yordamida til bilish savodxonligingizni oshirishingiz mumkin"))

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
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        binding.skip.setOnClickListener {
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
            }
        }


    }
}