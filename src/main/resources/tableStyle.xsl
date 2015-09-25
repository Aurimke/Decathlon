<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Athlete results</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Place</th>
                        <th>Score</th>
                        <th>Name</th>
                        <th>100m</th>
                        <th>Long jump</th>
                        <th>Shot put</th>
                        <th>High jump</th>
                        <th>400m</th>
                        <th>Hurdles</th>
                        <th>Discus throw</th>
                        <th>Pole vault</th>
                        <th>Javelin throw</th>
                        <th>1500m</th>
                    </tr>
                    <xsl:for-each select="table/row">
                        <tr>
                            <td><xsl:value-of select="place"/></td>
                            <td><xsl:value-of select="totalScore"/></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="meter100"/></td>
                            <td><xsl:value-of select="longJump"/></td>
                            <td><xsl:value-of select="shotPut"/></td>
                            <td><xsl:value-of select="highJump"/></td>
                            <td><xsl:value-of select="meter400"/></td>
                            <td><xsl:value-of select="hurdles"/></td>
                            <td><xsl:value-of select="discusThrow"/></td>
                            <td><xsl:value-of select="poleVault"/></td>
                            <td><xsl:value-of select="javelinThrow"/></td>
                            <td><xsl:value-of select="meter1500"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>