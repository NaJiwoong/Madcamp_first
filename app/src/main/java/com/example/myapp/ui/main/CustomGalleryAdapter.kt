
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView
import android.widget.TextView
import com.example.myapp.MainActivity
import com.example.myapp.R
import java.io.File

class CustomGalleryAdapter(internal var mContext: Context, internal var mBasePath: String) :
    BaseAdapter() {
    internal var CustomGalleryItemBg: Int = 0
    internal var mImgs: Array<String>
    internal var bm: Bitmap? = null

    var TAG = "Gallery Adapter Example :: "

    init {

        val file = File(mBasePath)
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.d(TAG, "failed to create directory")
            }
        }
        mImgs = file.list()

        /* 앞서 정의한 attrs.xml에서 gallery array의 배경 style attribute를 받아옴 */
        val array = mContext.obtainStyledAttributes(R.styleable.GalleryTheme)
        CustomGalleryItemBg =
            array.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0)
        array.recycle()
    }

    override fun getCount(): Int {
        return mImgs.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    // Override this method according to your need

    override fun getView(index: Int, view: View, viewGroup: ViewGroup): View {
        // TODO Auto-generated method stub
        val i = ImageView(mContext)

        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true

        val width = options.outWidth
        val height = options.outHeight
        var inSampleSize = 1
        val reqWidth = 256
        val reqHeight = 192
        if (width > reqWidth || height > reqHeight) {
            val halfHeight = height / 2
            val halfWidth = width / 2

            while (halfHeight / inSampleSize > reqHeight && halfWidth / inSampleSize > reqWidth) {
                inSampleSize *= 2
            }
        }
        options.inSampleSize = inSampleSize
        options.inJustDecodeBounds = false


        bm = BitmapFactory.decodeFile(mBasePath + File.separator + mImgs[index], options)
        val bm2 = ThumbnailUtils.extractThumbnail(bm, 300, 300)
        i.setLayoutParams(Gallery.LayoutParams(300, 300))
        i.setImageBitmap(bm2)
        i.setVisibility(ImageView.VISIBLE)

        i.setBackgroundResource(CustomGalleryItemBg)
        i.setScaleType(ImageView.ScaleType.FIT_CENTER)

        if (bm != null && !bm!!.isRecycled) {
            bm!!.recycle()
        }
        return i
    }
}