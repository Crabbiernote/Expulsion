#version 150

in vec4 Position;
in vec2 UV0;

out vec2 vTexCoord;

void main() {
    gl_Position = Position;
    vTexCoord = UV0;
}