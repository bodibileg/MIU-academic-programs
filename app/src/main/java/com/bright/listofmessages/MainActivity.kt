package com.bright.listofmessages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bright.listofmessages.ui.theme.ListOfMessagesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListOfMessagesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseList(
                        listOf(
                            Course(
                                "BA in Art, Consciousness, & Creative Practice",
                                "In our block system you’ll study one full-time course per month, giving you the time you need to dive deeply into each subject. You’ll be immersed in each studio class without the stress of juggling multiple courses and assignments."
                            ),
                            Course(
                                "BA in Consciousness & Human Potential",
                                "The BA in Consciousness & Human Potential integrates personal experience, philosophy of mind, neuroscience, and ancient wisdom.\n" + "Our goal for every student is enlightenment — the systematic development of full potential from within. This is the key to true fulfillment in daily life and any career."
                            ),
                            Course(
                                "BS in Computer Science",
                                "Our computer science program will prepare you for success by providing comprehensive knowledge of the discipline and by teaching you how to think clearly, precisely, and creatively."
                            ),
                            Course(
                                "BS in Mathematics",
                                "Mathematics is the study of nature from the perspective of orderliness. Mathematicians find and study patterns of orderliness and then use them to solve challenging problems in business and economics, data analysis, medical research, climate change, engineering and technology, physics, biology and agriculture, and the social sciences."
                            ),
                            Course(
                                "MA in ENLIGHTENMENT and LEADERSHIP",
                                "The foundation of this curriculum is the traditional knowledge and practical applications of the full development of human consciousness, as brought to light in a scientific framework by Maharishi Mahesh Yogi, and verified by 70 years of experience and more than 700 scientific studies."
                            ),
                            Course(
                                "MA in Studio Art",
                                "In our unique MA in Art, you’ll enjoy an intensive, two-semester exploration into studio practice while cultivating a deep connection to yourself through the Transcendental Meditation technique. In this creative environment, supported by expert faculty, peers, and prominent guest artists, you’ll create a sustainable studio practice — the best foundation for entering an MFA program or a career in art."
                            ),
                            Course(
                                "MBA with an ACCOUNTING SPECIALIZATION",
                                "MIU’s MBA in Accounting program is for students who want to deepen their knowledge of accounting and audit practices used in multinational companies and international non-governmental organizations (NGOs)."
                            ),
                            Course(
                                "MS in Aromatherapy & Ayurveda",
                                "As a student in this program, you’ll gain a robust knowledge of the therapeutic properties and practical applications of essential oils.\n" + "You’ll also learn Maharishi Ayurveda to enhance health and wellness and bring balance to both mind and body."
                            ),
                            Course(
                                "MS in Computer Science",
                                "Begin with 8-13 months of study on our U.S. campus. Learn leading edge technologies.  Study with expert faculty, top academics, and proven personal growth courses. "
                            ),
                            Course(
                                "PhD in Maharishi Vedic Science",
                                "Maharishi Vedic Science is the study of the unbounded, infinite field of consciousness lying at the basis of phenomenal existence and located within everyone as their own innermost Self. During the doctoral program, students will explore this field of intelligence both experientially – through daily practice of the Transcendental Meditation® technique and the TM-Sidhi® program – and by intellectual inquiry in classroom studies of the most advanced, most profound topics of Maharishi Vedic Science."
                            ),
                            Course(
                                "PhD in Physiology & Health",
                                "This PhD in Physiology & Health is a research program that is designed for graduate health professionals or those with a master’s in physiology, master of science in Maharishi AyurVeda and Integrative Medicine, or the equivalent, to conduct original research on the clinical effects and basic mechanisms of Maharishi AyurVeda, the Transcendental Meditation® technique, and other prevention-oriented, natural health care programs."
                            ),
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CourseList(courses: List<Course>) {
    LazyColumn {
        items(courses) { course -> CourseCard(course) }
    }
}

@Composable
fun CourseCard(course: Course) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.course),
            contentDescription = "course",
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp)
                .border(width = 2.dp, shape = CircleShape, color = Color.LightGray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        //create a mutable state variable that trigger UI updates when its value changes
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = course.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(modifier = Modifier.shadow(2.dp)) {
            Text(
                text = course.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(4.dp),
                maxLines = if (isExpanded) Int.MAX_VALUE else 1
            )
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Preview(showBackground = true)
@Composable
fun CourseListPreview() {
    ListOfMessagesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CourseList(
                listOf(
                    Course(
                        "BA in Art, Consciousness, & Creative Practice",
                        "In our block system you’ll study one full-time course per month, giving you the time you need to dive deeply into each subject. You’ll be immersed in each studio class without the stress of juggling multiple courses and assignments."
                    ),
                    Course(
                        "BA in Consciousness & Human Potential",
                        "The BA in Consciousness & Human Potential integrates personal experience, philosophy of mind, neuroscience, and ancient wisdom.\n" + "Our goal for every student is enlightenment — the systematic development of full potential from within. This is the key to true fulfillment in daily life and any career."
                    ),
                    Course(
                        "BS in Computer Science",
                        "Our computer science program will prepare you for success by providing comprehensive knowledge of the discipline and by teaching you how to think clearly, precisely, and creatively."
                    ),
                    Course(
                        "BS in Mathematics",
                        "Mathematics is the study of nature from the perspective of orderliness. Mathematicians find and study patterns of orderliness and then use them to solve challenging problems in business and economics, data analysis, medical research, climate change, engineering and technology, physics, biology and agriculture, and the social sciences."
                    ),
                )
            )
        }
    }
}

data class Course(
    val name: String,
    val description: String
)