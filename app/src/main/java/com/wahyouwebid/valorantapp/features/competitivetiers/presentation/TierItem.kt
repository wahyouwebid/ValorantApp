package com.wahyouwebid.valorantapp.features.competitivetiers.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.wahyouwebid.valorantapp.common.theme.ValoLightBlue
import com.wahyouwebid.valorantapp.features.competitivetiers.domain.model.Tier

@Composable
fun CompetitiveTierItem(
    tier: Tier
) {
    Card(
        modifier = Modifier
            .padding(12.dp),
        backgroundColor = ValoLightBlue
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GlideImage(
                imageModel = tier.largeIcon,
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(),
                modifier = Modifier.size(80.dp).padding(8.dp)
            )

            Text(
                text = tier.tierName.orEmpty(),
                style = MaterialTheme.typography.h6,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Gray
                            )
                        )
                    )
                    .padding(4.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}