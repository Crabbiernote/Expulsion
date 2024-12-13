#version 150

uniform sampler2D Sampler2;
in vec2 vTexCoord;
out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler2, vTexCoord);
    fragColor = vec4(0.0, 0.0, color.b, 1.0); // Keep only the blue channel
}