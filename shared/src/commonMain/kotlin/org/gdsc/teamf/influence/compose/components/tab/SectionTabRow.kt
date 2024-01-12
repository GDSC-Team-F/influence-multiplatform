package org.gdsc.teamf.influence.compose.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.festy.mobile.android.ui.components.tab.CustomScrollableTabRow
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette

data class SectionTab(
    val key: Any,
    val label: String,
)

@Stable
data class SectionTabRowState(
    val sections: List<SectionTab>,
) {

    var selectedSectionIndex by mutableStateOf(0)

}

@Composable
fun rememberSectionTabRowState(
    sections: List<SectionTab>,
): SectionTabRowState {
    return remember(sections) {
        SectionTabRowState(
            sections = sections
        )
    }
}


@Composable
fun SectionTabRow(
    sectionTabRowState: SectionTabRowState = rememberSectionTabRowState(sections = listOf()),
    onTabClicked : (Int) -> Unit
) {
    CustomScrollableTabRow(
        edgePadding = 20.dp,
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = sectionTabRowState.selectedSectionIndex,
        divider = { },
        indicator = { tabPositions ->
            Box(
                Modifier
                    .customTabIndicatorOffset(tabPositions[sectionTabRowState.selectedSectionIndex])
                    .height(2.dp)
                    .background(
                        color = LocalInfluenceColorPalette.current.adaptiveGray300,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
            )
        }
    ) {
        sectionTabRowState.sections.forEachIndexed { index, section ->
            Tab(
                modifier = Modifier.height(50.dp),
                selected = sectionTabRowState.selectedSectionIndex == index,
                onClick = { onTabClicked(index) },
                selectedContentColor = MaterialTheme.colorScheme.onSurface,
                unselectedContentColor = LocalInfluenceColorPalette.current.adaptiveGray500,
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = section.label,
                    style = InfluenceTypography.body3
                )
            }
        }
    }
}