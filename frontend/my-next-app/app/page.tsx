"use client"
import axios from "axios"
import { useEffect, useState } from "react"

export default function Home() {
  const [lang, setLang] = useState<string>("en")
  const [greeting, setGreeting] = useState<string>("")
  const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL

  const handleChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setLang(e.target.value)
  }
  useEffect(() => {
    const fetchData = async (): Promise<void> => {
      try {
        const result = await axios.get(`${API_BASE_URL}/greeting?lang=${lang}`)
        console.log(result.data)
        setGreeting(result.data)
      } catch (error) {
        console.log("백엔드 데이터 로드오류:", error)
        throw error
      }
    }
    fetchData()
  }, [lang])

  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <div className="text-xl m-2">Say Hello</div>
      <label htmlFor="language-select" className="text-xl m-2">
        언어선택
      </label>
      <select
        id="language-select"
        className="text-xl m-2"
        value={lang}
        onChange={handleChange}
      >
        <option value="en">영어</option>
        <option value="ko">한국어</option>
        <option value="jp">일본어</option>
      </select>
      <div className="text-xl m-2">{greeting}</div>
    </div>
  )
}
