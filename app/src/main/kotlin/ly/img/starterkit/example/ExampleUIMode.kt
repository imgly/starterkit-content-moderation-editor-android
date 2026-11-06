package ly.img.starterkit.example

import androidx.compose.runtime.Composable
import ly.img.editor.Editor
import ly.img.editor.EditorUiMode
import ly.img.editor.configuration.contentmoderation.ContentModerationConfigurationBuilder
import ly.img.editor.configuration.contentmoderation.moderation.GATEWAY_API_KEY
import ly.img.editor.configuration.contentmoderation.moderation.GatewayModerationProvider
import ly.img.editor.core.configuration.EditorConfiguration
import ly.img.editor.core.configuration.remember

@Composable
fun EditorUiModeScreen(onClose: (error: Throwable?) -> Unit) {
    Editor(
        license = null, // pass null or empty for evaluation mode with watermark
        uiMode = EditorUiMode.SYSTEM, // EditorUiMode.SYSTEM, EditorUiMode.LIGHT, EditorUiMode.DARK
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
