package com.example.swiftnewsapp.presentation.details.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.swiftnewsapp.R
import com.example.swiftnewsapp.domain.model.Article
import com.example.swiftnewsapp.domain.model.Source
import com.example.swiftnewsapp.presentation.onboarding.Dimens.ArticleImageHeight
import com.example.swiftnewsapp.presentation.onboarding.Dimens.MediumPadding1
import com.example.swiftnewsapp.ui.theme.SwiftNewsAppTheme

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
){

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT,article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = {
                event(DetailsEvent.SaveArticles)},
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ){
            item{
                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                
                Spacer(modifier = Modifier.height(MediumPadding1))
                
                Text(
                    text = article.title, 
                    style = MaterialTheme.typography.displaySmall, 
                    color = colorResource(
                         id = R.color.text_title
                    )
                
                )

                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.body
                    )

                )
                    
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    SwiftNewsAppTheme(dynamicColor = false) {
        DetailsScreen(article = Article(
            author = "",
            title = "Cryptocurrency firm Terraform Labs files for bankruptcy in US",
            description = "The cryptocurrency company behind the crashed TerraUSD and Luna tokens has filed for bankruptcy in the US.",
            content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
            publishedAt = "2024-01-16T22:24:33Z",
            source = Source(
                id = "", name = "bbc"
            ),
            url = "https://www.bbc.co.uk/news/technology-68055557",
            urlToImage = "https://ichef.bbci.co.uk/news/976/cpsprodpb/1238F/production/_132393647_7c254e470e2326f409f39d14db03892ae2a54ef6.jpg.webp"
        ),
            event = {}
        ) {
            
        }
        
    }
}