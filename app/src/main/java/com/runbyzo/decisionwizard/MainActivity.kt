import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.runbyzo.decisionwizard.decisionMethods.SAW
import com.runbyzo.decisionwizard.ui.theme.DecisionWizardTheme


val companies = listOf<String>("Mpstats.io", "Moneyplace.io", "Маяк", "MarketGuru", "Shopstat")

val props = listOf(
    doubleArrayOf(1.0,9.0,8.0,8.0,7.0),
    doubleArrayOf(9.0,9.0,8.0,7.0,6.0),
    doubleArrayOf(9.0,8.0,8.0,8.0,7.0),
    doubleArrayOf(10.0,9.0,7.0,8.0,7.0),
    doubleArrayOf(9.0,8.0,9.0,9.0,6.0),
    doubleArrayOf(5.0,6.0,9.0,7.0,10.0)
)

val benefit = booleanArrayOf(true, true, true, true, false)
val weights = doubleArrayOf(0.25, 0.25, 0.15, 0.25, 0.10)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionWizardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DecisionWizardTheme {
        Greeting("Android")
    }
}