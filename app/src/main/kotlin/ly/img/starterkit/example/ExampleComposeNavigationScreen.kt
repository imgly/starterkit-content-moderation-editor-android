package ly.img.starterkit.example

import androidx.compose.runtime.Composable
import ly.img.editor.Editor
import ly.img.editor.configuration.contentmoderation.ContentModerationConfigurationBuilder
import ly.img.editor.configuration.contentmoderation.moderation.GATEWAY_API_KEY
import ly.img.editor.configuration.contentmoderation.moderation.GatewayModerationProvider
import ly.img.editor.core.configuration.EditorConfiguration
import ly.img.editor.core.configuration.remember

// onClose should pop screen from the backstack of jetpack compose navigation
@Composable
fun EditorScreen(onClose: (Throwable?) -> Unit) {
    Editor(
        license = null, // pass null or empty for evaluation mode with watermark
        configuration = {
            EditorConfiguration.remember(
                builderFactory = {
                    ContentModerationConfigurationBuilder(
                        moderationProvider = GatewayModerationProvider(apiKey = GATEWAY_API_KEY),
                    )
                },
            )
        },
        onClose = onClose,
    )
}
